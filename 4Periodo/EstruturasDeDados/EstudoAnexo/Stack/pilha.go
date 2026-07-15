package main

import (
	"errors"
)

func (p *Pilha) EstaCheia() bool {
	return p.tamanho == p.maxItens
}

func (p *Pilha) EstaVazia() bool {
	return (p.tamanho == 0)
}

func (p *Pilha) Push(item TipoItem) error {
	if p.EstaCheia() {
		return errors.New("PilhaCheiaError")
	}
	p.estrutura[p.tamanho] = item
	p.tamanho++
	return nil
}

func (p *Pilha) Pop() (TipoItem, error) {
	if p.EstaVazia() {
		return 0, errors.New("PilhaVaziaError")
	}
	p.tamanho--
	item := p.estrutura[p.tamanho]
	p.estrutura[p.tamanho] = 0
	return item, nil
}

func (p *Pilha) View() []TipoItem {
	return p.estrutura
}

func (p *Pilha) QualTamanho() int {
	return p.tamanho
}
