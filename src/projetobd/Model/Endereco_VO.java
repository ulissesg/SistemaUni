/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobd.Model;

/**
 *
 * @author uliss
 */
public class Endereco_VO {
    private String PKEndereco;
    private String newPKEndereco;
    private String cep;
    private String numero;
    private String rua;
    private String cidade;
    private String pais;
    private String complemento;
    private String FKGrr;

    public String getPKEndereco() {
        return PKEndereco;
    }

    public void setPKEndereco(String PKEndereco) {
        this.PKEndereco = PKEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getFKGrr() {
        return FKGrr;
    }

    public void setFKGrr(String FKGrr) {
        this.FKGrr = FKGrr;
    }

    public String getNewPKEndereco() {
        return newPKEndereco;
    }

    public void setNewPKEndereco(String newPKEndereco) {
        this.newPKEndereco = newPKEndereco;
    }
}
