import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Usuario} from '../assets/models/usuario'
import usuarioJson from '../assets/data/usuario.json'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']

})
export class AppComponent {
  title = 'Escuela Tenis Olula del Rio';
  public usuario:Usuario;

  public constructor() {
    this.usuario=usuarioJson;
  }

}


