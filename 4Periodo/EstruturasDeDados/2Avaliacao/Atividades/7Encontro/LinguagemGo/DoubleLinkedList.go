package main

import "fmt"

type No struct {
	dado int
	ant  *No
	prox *No
}
type ListaDupla struct {
	inicio *No
	fim    *No
}

func (l *ListaDupla) inserirFim(dado int) {
	ultimo := &No{dado: dado}
	if l.inicio == nil {
		ultimo.ant = nil
		l.inicio = ultimo
		l.fim = ultimo
	} else {
		ultimo.ant = l.fim
		l.fim.prox = ultimo
		l.fim = ultimo
	}
}

func (l *ListaDupla) remover(alvo *No) {
	if l == nil || l.inicio == nil || alvo == nil {
		return
	}
	if l.inicio == alvo {
		if l.inicio.prox != nil {
			l.inicio = l.inicio.prox
			l.inicio.ant = nil
		} else {
			l.inicio = nil
			l.fim = nil
		}
		return
	}
	if l.fim == alvo {
		if l.fim.ant != nil {
			l.fim = l.fim.ant
			l.fim.prox = nil
		} else {
			l.inicio = nil
			l.fim = nil
		}
		return
	}
	if alvo.ant != nil {
		alvo.ant.prox = alvo.prox
	}
	if alvo.prox != nil {
		alvo.prox.ant = alvo.ant
	}
}

func (l *ListaDupla) imprimirTras() {
	if l.fim == nil {
		return
	}
	nodeAtual := l.fim
	for nodeAtual != nil {
		fmt.Printf("%d\n", nodeAtual.dado)
		nodeAtual = nodeAtual.ant
	}
}

func (l *ListaDupla) imprimirFrente() {
	if l.inicio == nil {
		return
	}
	nodeAtual := l.inicio
	for nodeAtual != nil {
		fmt.Printf("%d\n", nodeAtual.dado)
		nodeAtual = nodeAtual.prox
	}
}
