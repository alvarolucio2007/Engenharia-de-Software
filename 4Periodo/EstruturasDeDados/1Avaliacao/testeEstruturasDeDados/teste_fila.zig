const std = @import("std");
pub const ChanError = error{
    EstaCheia,
    EstaVazia,
};
const Fila = struct {
    primeiro: usize,
    ultimo: usize,
    estrutura: []usize,
    maxItens: i32,
    pub fn init(primeiro: usize, estrutura: []i32, maxItens: i32) Fila {
        return Fila{
            .primeiro = primeiro,
            .ultimo = primeiro, //Ao inicializar fila, primeiro é o ultimo também.
            .estrutura = estrutura,
            .maxItens = maxItens,
        };
    }
    fn estaCheia(self: Fila) bool {
        return ((self.ultimo + 1) % self.maxItens) == self.primeiro;
    }
    fn estaVazia(self: Fila) bool {
        return self.primeiro == self.ultimo;
    }
    fn push(self: *Fila, novoItem: usize) ChanError!void {
        if (self.estaCheia()) {
            return ChanError.EstaCheia;
        }
        self.estrutura[self.ultimo] = novoItem;
        self.ultimo = (self.ultimo + 1) % self.maxItens;
        return;
    }
    fn pop(self: *Fila) ChanError!usize {
        if (self.estaVazia()) {
            return ChanError.EstaVazia;
        }
        const valor: usize = self.estrutura[self.primeiro];
        self.primeiro = (self.primeiro + 1) % self.maxItens;
        return valor;
    }
    fn view(self: Fila) ChanError!usize {
        if (self.estaVazia()) {
            return ChanError.EstaVazia;
        }
        return self.estrutura[self.primeiro];
    }
};
