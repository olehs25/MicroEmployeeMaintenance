import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginData = {
    email: '',
    password: ''
  };


  constructor(private snack:MatSnackBar, private loginService:AuthService, private router: Router) { }

  hide = true;
  ngOnInit(): void {
  }

  formSubmit() {
    console.log(this.loginData);
    if (this.loginData.email.trim() == '' || this.loginData.email == null) {
      Swal.fire({
        title: 'Email obligatorio',
        text: 'Debe introducir un email válido para poder iniciar sesión',
        icon: 'warning',
        confirmButtonText: 'Ok',
        confirmButtonColor: '#2d336b'
      });
      return;
    }
    if (this.loginData.password.trim() == '' || this.loginData.password == null) {
      Swal.fire({
        title: 'Contraseña obligatoria',
        text: 'Debe introducir una contraseña válida para poder iniciar sesión',
        icon: 'warning',
        confirmButtonText: 'Ok',
        confirmButtonColor: '#2d336b'
      });
      return;
    }

    this.loginService.generateToken(this.loginData).subscribe(
        (data:any)=>{
          console.log('Token obtenido');
          console.log(data);
          this.loginService.loginUser(data.token);
          this.loginService.getCurrentUser().subscribe((user:any)=>{
            console.log(user);
            this.loginService.setUser(user);
            if(this.loginService.getUserRole()=='SuperSysAdmin'){
              // window.location.href='/admin';
              // this.router.navigate(['admin']);
              this.loginService.loginStatusSubject.next(true);
              // window.location.reload();
              window.location.href='/admin';

            }else if (this.loginService.getUserRole()=='usuario'){
              // window.location.href='/user';
              this.router.navigate(['user']);
              this.loginService.loginStatusSubject.next(true);
              window.location.href='/user';
            } else if(this.loginService.getUserRole()=='SuperSysAdminComunidad'){
              this.loginService.loginStatusSubject.next(true);
              window.location.href='/adminComunidad';

            }else if (this.loginService.getUserRole()=='usuarioComunidad'){
              this.loginService.loginStatusSubject.next(true);
              window.location.href='/userComunidad';
            } else {
              this.loginService.logout();
              Swal.fire({
                title: 'Permiso denegado',
                text: 'No tiene permisos para acceder a esta página',
                icon: 'warning',
                confirmButtonText: 'Aceptar',
                confirmButtonColor: '#2d336b'
              });
              return;

            }
          })
        }, (error)=>{
          Swal.fire({
            title: 'Error',
            text: 'Email o contraseña incorrectos',
            icon: 'error',
            confirmButtonText: 'Ok',
            confirmButtonColor: '#2d336b'
          });


        }
    );

  }
}
