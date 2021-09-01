import { Categoria } from "./Categoria";
import { Usuario } from "./Usuario";

export class Produto{
    public caracteristicas: string;
    public categoria: Categoria;
    public descricao: string;
    public id: number;
    public nomeProduto: string;
    public usuario: Usuario;
    public valor: number;
}