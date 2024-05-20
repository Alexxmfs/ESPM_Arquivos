package br.espm.cargo;

public enum Cargo {
    ATENDENTE {
        @Override
        public double calcularComissao(double valor) {
            return valor * 0.10;
        }
    },

    VENDEDOR {
        public double calcularComissao(double valor) {
            return valor * 0.15 + 5;
        }
    },

    GERENTE 
}