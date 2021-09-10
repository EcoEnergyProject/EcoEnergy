import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { } 

  token = {
    headers: new HttpHeaders().set("Authorization", environment.token) // inclusão do token para liberação do acesso. 
  }

  // metodo GetAll onde retorna todas as categorias. 
  getAllCategoria(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>(`${environment.apiUrl}/categoria`, this.token) // incluimos a url no enviroment. 
  }

  // criação do metodo getByIdCategoria. 
  getByIdCategoria(id: number): Observable<Categoria>{
    return this.http.get<Categoria>(`${environment.apiUrl}/categoria/${id}`, this.token)
  }

  // criação do metodo getByTipoCategoria 
  getByTipoCategoria(tipo: string): Observable<Categoria[]>{
    return this.http.get<Categoria[]>(`${environment.apiUrl}/categoria/tipo/${tipo}`, this.token)
  } 

  // metodo para cadastrar categorias. 
  postCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.post<Categoria>(`${environment.apiUrl}/categoria`, categoria, this.token)
  } 

  // metodo put categoria:
  putCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.put<Categoria>(`${environment.apiUrl}/categoria`, categoria, this.token)
  }

  // metodo delete categoria:
  deleteCategoria(id: number) {
    return this.http.delete(`${environment.apiUrl}/categoria/${id}`, this.token)
  }
}