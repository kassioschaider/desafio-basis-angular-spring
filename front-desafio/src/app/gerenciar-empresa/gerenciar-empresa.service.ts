import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Empresa } from './models/empresa.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GerenciarEmpresaService {

  private resouceUrl = environment.apiUrl + '/empresas';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  obterTodos(): Observable<Empresa> {
    return this.http.get(this.resouceUrl);
  }

  cadastrar(empresa: Empresa): Observable<Empresa> {
    return this.http
      .post(this.resouceUrl, JSON.stringify(empresa), this.httpOptions);
  }

  obterPorId(id: number): Observable<Empresa> {
    return this.http
      .get(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  excluirPorId(id: number) {
    return this.http
      .delete(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  atualizar(empresa: Empresa): Observable<Empresa> {
    return this.http
      .put(this.resouceUrl, JSON.stringify(empresa), this.httpOptions);
  }
}
