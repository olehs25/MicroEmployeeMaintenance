import {Component, OnInit} from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import Swal from "sweetalert2";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  hide = true;
  public usuario = {
    nombre: '',
    apellidos: '',
    dni: '',
    email: '',
    password: '',
    birthDate: '',
    telefono: '',
  };

  constructor(
    private userService: UserService,
    private snack: MatSnackBar
  ) {}

  ngOnInit(): void {}



  checkEmail(email: string): Promise<Boolean> {
    return new Promise((resolve, reject) => {
      this.userService.checkEmail(email).subscribe(
        (data) => {
          if (data === true) {
            resolve(true);
          } else {
            reject(false);
          }
        },
        (error) => {
          reject(error);
        }
      );
    });
  }





  // checkEmail(email: string): Boolean {
  //   this.usuarioService.checkEmail(email).subscribe(
  //     (data) => {
  //       console.log('metodo checkEmail');
  //       console.log(data);
  //       if (data === true) {
  //         console.log('El email está registrado');
  //         return true;
  //       } else {
  //         return false;
  //       }
  //     },
  //     (error) => {
  //       console.log(error);
  //       return error;
  //     }
  //   );
  //   return false;
  // }

  formSubmit() {
    console.log('Form submitted');
    console.log(this.usuario);
    if (
      this.usuario.nombre == '' ||
      this.usuario.apellidos == '' ||
      this.usuario.dni == '' ||
      this.usuario.email == '' ||
      this.usuario.password == '' ||
      this.usuario.birthDate == '' ||
      this.usuario.telefono == ''
    ) {
      Swal.fire({
        title: 'Campos obligatorios',
        text: 'Todos los campos son obligatorios',
        icon: 'warning',
        confirmButtonColor: '#2d336b',
        confirmButtonText: 'Aceptar',

      });
      return;
    }

    //compruebo que el email sea correcto
    if (!/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/.test(this.usuario.email)) {
      Swal.fire({
        title: 'Email inválido',
        text: 'El email introducido no tiene un formato válido',
        icon: 'info',
        confirmButtonText: 'Aceptar',
        confirmButtonColor: '#2d336b',
      });
      return;
    }
    //compruebo que el telefono sea correcto (9 digitos)
    if (!/^[0-9]{9}$/.test(this.usuario.telefono)) {
      Swal.fire({
        title: 'Teléfono inválido',
        text: 'El teléfono introducido debe ser de (9 dígitos)',
        icon: 'info',
        confirmButtonText: 'Aceptar',
        confirmButtonColor: '#2d336b',
      });
      return;
    }

    //compruebo que la contraseña tenga al menos 8 caracteres
    if (this.usuario.password.length < 8) {
      Swal.fire({
        title: 'Contraseña inválida',
        text: 'La contraseña debe tener al menos 8 caracteres',
        icon: 'info',
        confirmButtonText: 'Aceptar',
        confirmButtonColor: '#2d336b',
      });
      return;
    }


    this.checkEmail(this.usuario.email).then(
      (data) => {
        console.log('El email está registrado');
        Swal.fire({
          title: 'Email ya registrado',
          text: 'El email introducido ya está registrado en el Sistema',
          icon: 'warning',
          confirmButtonText: 'Aceptar',
          confirmButtonColor: '#2d336b',
        });
        return;
      },
      (error) => {
        console.log('El email no está registrado');
        this.userService.registrarUsuario(this.usuario).subscribe(
          (data: any) => {
            console.log(data);
            Swal.fire({
              title: 'Usuario registrado',
              text: 'Usuario registrado correctamente',
              icon: 'success',
              confirmButtonText: 'Aceptar',
              confirmButtonColor: '#2d336b',
            }).then((result) => {
              if (result.isConfirmed) {
                window.location.reload();
              }
            });
            return;
          },
          (error: any) => {

            console.log(error);
            Swal.fire({
              title: 'Error en el registro',
              text: 'Ha ocurrido un error en el registro',
              icon: 'error',
              confirmButtonText: 'Aceptar',
              confirmButtonColor: '#2d336b',
            });
            return;
          }
        );
      }
    );



    //compruebo que el email no esté ya registrado
    // if (this.checkEmail(this.usuario.email)) {
    //   Swal.fire({
    //     title: 'Email ya registrado',
    //     text: 'El email introducido ya está registrado en el Sistema',
    //     icon: 'warning',
    //     confirmButtonText: 'Aceptar',
    //   });
    //   return;
    // } else {
    //   this.usuarioService.registrarUsuario(this.usuario).subscribe(
    //     (data) => {
    //       console.log(data);
    //       Swal.fire({
    //         title: 'Usuario registrado',
    //         text: 'Usuario registrado correctamente',
    //         icon: 'success',
    //         confirmButtonText: 'Aceptar',
    //       });
    //       return;
    //     },
    //     (error) => {
    //       console.log(error);
    //       Swal.fire({
    //         title: 'Error en el registro',
    //         text: 'Ha ocurrido un error en el registro',
    //         icon: 'error',
    //         confirmButtonText: 'Aceptar',
    //       });
    //       return;
    //     }
    //   );
    // }

    // this.usuarioService.registrarUsuario(this.usuario).subscribe(
    //   data => {
    //     console.log(data);
    //     Swal.fire({
    //       title: 'Usuario registrado',
    //       text: 'Usuario registrado correctamente',
    //       icon: 'success',
    //       confirmButtonText: 'Aceptar'
    //     });
    //   } ,
    //   error => {
    //     console.log(error);
    //     this.snack.open("Ha ocurrido un error en el Registro", "Aceptar", {
    //       duration: 5000,
    //       verticalPosition: 'top',
    //       });
    //   },
    // );
  }
}
