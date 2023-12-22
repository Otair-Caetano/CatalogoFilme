import java.util.ArrayList;
import java.util.List;

// Classe abstrata para representar uma pessoa (ator ou diretor)
abstract class Pessoa {
    private final String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

// Classe para representar um ator
class Ator extends Pessoa {
    public Ator(String nome) {
        super(nome);
    }
}

// Classe para representar um diretor
class Diretor extends Pessoa {
    public Diretor(String nome) {
        super(nome);
    }
}

// Classe abstrata para representar um item no catálogo
abstract class CatalogoItem {
    private final String nome;

    public CatalogoItem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

// Classe para representar um filme
class Filme extends CatalogoItem {
    private final Diretor diretor;
    private final List<Ator> atores;

    public Filme(String nome, Diretor diretor) {
        super(nome);
        this.diretor = diretor;
        this.atores = new ArrayList<>();
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void adicionarAtor(Ator ator) {
        atores.add(ator);
    }
}

// Classe para representar o catálogo de filmes
class CatalogoFilmes {
    private final List<Filme> filmes;

    public CatalogoFilmes() {
        this.filmes = new ArrayList<>();
    }

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> pesquisarFilmesPorNome(String nome) {
        List<Filme> resultados = new ArrayList<>();
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                resultados.add(filme);
            }
        }
        return resultados;
    }
}

class Main {
    public static void main(String[] args) {
        // Exemplo de uso
        Diretor diretor = new Diretor("Christopher Nolan");
        Ator ator1 = new Ator("Leonardo DiCaprio");
        Ator ator2 = new Ator("Tom Hardy");

        Filme filme = new Filme("Inception", diretor);
        filme.adicionarAtor(ator1);
        filme.adicionarAtor(ator2);

        CatalogoFilmes catalogo = new CatalogoFilmes();
        catalogo.cadastrarFilme(filme);

        // Pesquisar filme por nome
        List<Filme> resultados = catalogo.pesquisarFilmesPorNome("Inception");
        for (Filme resultado : resultados) {
            System.out.println("Nome do Filme: " + resultado.getNome());
            System.out.println("Diretor: " + resultado.getDiretor().getNome());
            System.out.println("Atores:");
            for (Ator ator : resultado.getAtores()) {
                System.out.println("- " + ator.getNome());
            }
            System.out.println("------------------------------");
        }
    }
}
