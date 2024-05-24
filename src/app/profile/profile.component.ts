import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {Usuario} from "../../assets/models/usuario";
import {UsuarioDTO} from "../models/usuarioDTO";



@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit{

// @Input() usuario:string='';

  usuario:Usuario;
  constructor(userService: UserService) {
    this.usuario = userService.getItem('usuario');
  }


  ngOnInit(): void {
  }


}

