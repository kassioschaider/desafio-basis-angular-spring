import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Funcionario } from './models/funcionario.model';

@Injectable({
  providedIn: 'root'
})
export class GerenciarFuncionarioService {

  private resouceUrl = environment.apiUrl + '/funcionarios';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  obterTodos(): Observable<Funcionario> {
    return this.http.get(this.resouceUrl);
  }

  cadastrar(funcionario: Funcionario): Observable<Funcionario> {
    return this.http
      .post(this.resouceUrl, JSON.stringify(funcionario), this.httpOptions);
  }

  obterPorId(id: number): Observable<Funcionario> {
    return this.http
      .post(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  excluirPorId(id: number) {
    return this.http
      .delete(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  atualizar(funcionario: Funcionario): Observable<Funcionario> {
    return this.http
      .put(this.resouceUrl, JSON.stringify(funcionario), this.httpOptions);
  }
}
