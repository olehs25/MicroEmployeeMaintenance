import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {API_URL, API_URL_CHECK_EMAIL} from "./helper";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) {
  }

  getItem(key : string){
    const item = localStorage.getItem(key);
    return (item) ? JSON.parse(item) : null;
  }

  setItem(key : string, value:any){
    localStorage.setItem(key, JSON.stringify(value));
  }

  removeItem(key : string){
      localStorage.removeItem(key);
  }

  clear(){
    localStorage.clear();
  }
  public checkEmail(email: string) {
    return this.httpClient.get(API_URL_CHECK_EMAIL + email);
  }

  public registrarUsuarioComunidad(usuario:any, idComunidad:number){
    return this.httpClient.post(API_URL+"usuarios/createComunidad/"+idComunidad, usuario);
  }

  public registrarUsuario(usuario:any){
    return this.httpClient.post(API_URL+"usuarios/create", usuario);
  }

}
