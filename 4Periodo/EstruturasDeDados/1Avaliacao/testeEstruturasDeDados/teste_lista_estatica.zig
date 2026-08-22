const std = @import("std");
pub const ListaError = error{
    EstaCheia,
    EstaVazia,
    IndiceInvalido,
};
const ListaEstatica = struct {
    buffer: []i32,
    tamanho: usize,
    pub fn init(buffer: []i32) ListaEstatica {
        return ListaEstatica{
            .buffer = buffer,
            .tamanho = 0,
        };
    }
    fn estaCheia(self: ListaEstatica) bool {
        return self.buffer.len == self.tamanho;
    }
    fn estaVazia(self: ListaEstatica) bool {
        return self.tamanho == 0;
    }
    fn append(self: *ListaEstatica, valor: i32) ListaError!void {
        if (self.estaCheia()) {
            return ListaError.EstaCheia;
        }
        self.buffer[self.tamanho] = valor;
        self.tamanho += 1;
    }
    fn get(self: ListaEstatica, indice: usize) ListaError!i32 {
        if (indice >= self.tamanho) {
            return ListaError.IndiceInvalido;
        }
        return self.buffer[indice];
    }
    fn pop(self: *ListaEstatica) ListaError!i32 {
        if (self.estaVazia()) {
            return ListaError.EstaVazia;
        }
        self.tamanho -= 1;
        return self.buffer[self.tamanho];
    }
};
pub fn main() !void {
    var memoria: [5]i32 = undefined;
    var lista = ListaEstatica.init(&memoria);

    // Teste seu codigo aqui!
    try lista.append(42);
    std.debug.print("{d}\n", .{try lista.pop()});
    std.debug.print("{d}\n", .{try lista.get(0)});
}
