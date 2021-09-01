import { Produto } from "./Produto";

export class Categoria{
    public descricaoCategoria: string;
    public id: number;
    public palavraChave: string;
    public produto: Produto[];
    public tipo: string;
}