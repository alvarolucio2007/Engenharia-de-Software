const std = @import("std");
pub const StackError = error{
    EstaCheia,
    EstaVazia,
};
const Pilha = struct {
    tamanho: usize,
    maxItens: usize,
    estrutura: []i32,
    pub fn init(maxItens: usize, estrutura: []i32) Pilha {
        return Pilha{
            .tamanho = 0,
            .maxItens = maxItens,
            .estrutura = estrutura,
        };
    }
    fn estaCheia(self: Pilha) bool {
        return self.tamanho == self.maxItens;
    }
    fn estaVazia(self: Pilha) bool {
        return self.tamanho == 0;
    }
    fn push(self: *Pilha, novoItem: i32) StackError!void {
        if (self.estaCheia()) {
            return StackError.EstaCheia;
        }
        self.estrutura[self.tamanho] = novoItem;
        self.tamanho += 1;
        return;
    }
    fn pop(self: *Pilha) StackError!i32 {
        if (self.estaVazia()) {
            return StackError.EstaVazia;
        }
        self.tamanho -= 1;
        return self.estrutura[self.tamanho];
    }
    fn view(self: Pilha) StackError!i32 {
        if (self.estaVazia()) {
            return StackError.EstaVazia;
        }
        return self.estrutura[self.tamanho - 1];
    }
};
pub fn main() !void {
    var buffer: [10]i32 = undefined; // Aloca espaco para os itens
    var pilha = Pilha.init(10, &buffer);

    try pilha.push(10);
    try pilha.push(20);

    const topo = try pilha.view();
    std.debug.print("{d}\n", .{topo}); // Usa {d} para inteiros
}
