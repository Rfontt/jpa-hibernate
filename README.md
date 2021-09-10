# JPA - Java Persistence API

É um framework para persistir objetos java. Serve para lidar com as tabelas do banco de dados.

# Hibernate 

É um framework para o mapeamento objeto-relacional. Serve para lidar com as operações do banco de dados.


# Clico de vida 

Quando criamos uma instância de uma classeJPA ela está, inicialmente, na fase de **transient**. Nessa fase ela não faz exatamente nada e é vista como uma classe comum.

Quando declaramos o metódo **persist()**, ela vai para a fazer de **managed**, a qual já está fazendo alterações no banco de dados e ainda pode atualizar os dados inseridos.

Ao fecharmos a conexão do entityManager **close()** a classe vai para a fase de **detached** e não irá mais fazer alterações no banco de dados.

# Transient

Usamos o persist() para salvar algo no banco de dados e o commit ou flush para persistir no banco de dados.

# Managed

Antes do close e clear podemos usar o find(), createQuery(), removed().

# Detached

Depois que estiver nessa transição é preciso usar o merge para voltar a entidade para a fase de managed.