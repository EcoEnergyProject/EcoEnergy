import { Produto } from "./Produto";

export class Usuario{
    public adm: string;
    public email: string;
    public id: number;
    public nomeCompleto: string;
    public produto: Produto[];
    public senha: string;
}