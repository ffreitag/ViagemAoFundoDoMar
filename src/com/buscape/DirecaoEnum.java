package com.buscape;

public enum DirecaoEnum {

    NORTE('N', "Norte"), SUL('S', "Sul"), LESTE('L', "Leste"), OESTE('O', "Oeste");

    private Character sigla;
    private String descricao;

    DirecaoEnum(final Character sigla, final String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public static DirecaoEnum getEnumBySigla(final Character sigla) {
        for (DirecaoEnum enun : values()) {
            if (enun.getSigla().equals(sigla)) {
                return enun;
            }
        }
        return null;
    }

    public static String getDesclicaoBySigla(final Character sigla) {
        for (DirecaoEnum enun : values()) {
            if (enun.getSigla().equals(sigla)) {
                return enun.getDescricao();
            }
        }
        return null;
    }

    public Character getSigla() {
        return sigla;
    }

    public void setSigla(Character sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
}
