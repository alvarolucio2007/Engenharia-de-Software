package pilha

import (
	"errors"
)

func (p *Pilha) EstaCheia() bool {
	return (p.tamanho == max_itens)
}

func (p *Pilha) EstaVazia() bool {
	return (p.tamanho == 0)
}

func (p *Pilha) Push(item TipoItem) error {
	if p.EstaCheia() {
		return errors.New("PilhaCheiaError")
	}
	p.estrutura = append(p.estrutura, item)
	p.tamanho++
	return nil
}

func (p *Pilha) Pop() (TipoItem, error) {
	if p.EstaVazia() {
		return 0, errors.New("PilhaVaziaError")
	}
	p.tamanho -= 1
	return p.estrutura[p.tamanho], nil
}

func (p *Pilha) View() []TipoItem {
	return p.estrutura
}

func (p *Pilha) QualTamanho() int {
	return p.tamanho
}
