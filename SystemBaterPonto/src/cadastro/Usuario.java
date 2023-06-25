package cadastro;

public class Usuario {

    private int id_usuario;
    private String nome;
    private String usuarios;
    private String senha;
    private String cpf;
    private String rg;
    private String cargo;
    private String dataNascimento;
    private String IdentificadoUnico;
    private String telefone;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String referencia;
    private String complemento;
    private String numero;
    private String cep;

    public Usuario(int id_usuario, String nome, String usuarios, String senha, String cpf, String rg, String cargo, String dataNascimento, String IdentificadoUnico, String telefone, String estado, String cidade, String bairro, String rua, String referencia, String complemento, String numero) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.usuarios = usuarios;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.IdentificadoUnico = IdentificadoUnico;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.referencia = referencia;
        this.complemento = complemento;
        this.numero = numero;
    }
 ///
    public Usuario(String nome) {
        this.nome = nome;
    }
////   
    public Usuario(String nome, String usuarios, String senha, String cpf, String rg, String cargo, String dataNascimento, String IdentificadoUnico, String telefone, String estado, String cidade, String bairro, String rua, String referencia, String complemento, String numero, String cep) {
        this.nome = nome;
        this.usuarios = usuarios;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.cargo = cargo;
        this.dataNascimento = dataNascimento;
        this.IdentificadoUnico = IdentificadoUnico;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.referencia = referencia;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
    }

    public Usuario(int id) {
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id_usuario;
    }

    public void setId(int id) {
        this.id_usuario = id;
    }

   

    //Busca somente a senha e usuario de acessor
    public Usuario(int id_usuario, String usuarios, String senha) {
        this.id_usuario = id_usuario;
        this.usuarios = usuarios;
        this.senha = senha;

    }

    //
    public Usuario(String usuarios, String senha) {
        this.usuarios = usuarios;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuario(String usuario) {
        this.usuarios = usuarios;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIdentificadoUnico() {
        return IdentificadoUnico;
    }

    public void setIdentificadoUnico(String IdentificadoUnico) {
        this.IdentificadoUnico = IdentificadoUnico;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
