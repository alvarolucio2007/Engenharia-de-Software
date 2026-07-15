package main

import "errors"

func NewPilhaDinamica() PilhaDinamica {
	return PilhaDinamica{nodeTopo: nil}
}

func (p *PilhaDinamica) EstaVazia() bool {
	return p.nodeTopo == nil
}

func (p *PilhaDinamica) Push(item TipoItem) {
	newNode := &Node{
		valor:   item,
		proximo: p.nodeTopo,
	}
	p.nodeTopo = newNode
}

func (p *PilhaDinamica) Pop() (TipoItem, error) {
	if p.EstaVazia() {
		return 0, errors.New("PilhaVaziaError")
	}
	item := p.nodeTopo.valor
	p.nodeTopo = p.nodeTopo.proximo
	return item, nil
}

func (p *PilhaDinamica) View() []TipoItem {
	tempNode := p.nodeTopo
	tamanho := p.QualTamanho()
	res := make([]TipoItem, 0, tamanho)
	for tempNode != nil {
		res = append(res, tempNode.valor)
		tempNode = tempNode.proximo
	}
	return res
}

func (p *PilhaDinamica) QualTamanho() int {
	tamanho := 0
	for n := p.nodeTopo; n != nil; n = n.proximo {
		tamanho++
	}
	return tamanho
}
