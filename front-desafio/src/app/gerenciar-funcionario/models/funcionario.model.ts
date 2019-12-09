export class Funcionario {

  constructor(
    public id?: number,
    public nome?: string,
    public dataNascimento?: Date,
    public cpf?: string,
    public idEmpresa?: number,

    public nomeEmpresa?: string
  ) { }
}
