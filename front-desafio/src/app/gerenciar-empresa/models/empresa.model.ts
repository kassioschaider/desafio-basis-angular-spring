import { Funcionario } from 'src/app/gerenciar-funcionario/models/funcionario.model';

export class Empresa {

  constructor(
    public id?: number,
    public nome?: string,
    public endereco?: string,
    public cnpj?: string,
    public funcionarios?: Funcionario[]
  ) { }
}
