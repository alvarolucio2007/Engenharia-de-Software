package main

type Pessoa struct {
	ID         uint
	Nome       string
	Logradouro string
	Numero     uint
	CEP        string
	Bairro     string
	Cidade     string
	UF         string
	Telefone   string // não é uint pq pode começar com 0 (ex: 086 999...)
	CPFCNPJ    string
}

func ConstructorPessoa(id uint, nome string, logradouro string, numero uint, cep string, bairro string, cidade string, uf string, telefone string, cpfcnpj string) Pessoa {
	return Pessoa{id, nome, logradouro, numero, cep, bairro, cidade, uf, telefone, cpfcnpj}
}

type Associado struct {
	Pessoa
	Situacao        string
	NumeroAssociado string
}

func ConstructorAssociado(p Pessoa, situacao, num string) *Associado {
	return &Associado{p, situacao, num}
}

type Colaborador struct {
	Pessoa
	CargoFuncao string
}

func ConstrutorColaborador(p Pessoa, cargofuncao string) *Colaborador {
	return &Colaborador{p, cargofuncao}
}

type Fornecedor struct {
	Pessoa
	NomeFantasia string
	Website      string
}

func ConstrutorFornecedor(p Pessoa, nomefantasia, website string) *Fornecedor {
	return &Fornecedor{p, nomefantasia, website}
}
