@PostMapping
public ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody UsuarioRequest request) {
    try {
        return ResponseEntity.ok(usuarioService.criarUsuario(request));
    } catch (ConflictException ex) {
        throw ex; // Será tratado pelo GlobalExceptionHandler
    }
}
