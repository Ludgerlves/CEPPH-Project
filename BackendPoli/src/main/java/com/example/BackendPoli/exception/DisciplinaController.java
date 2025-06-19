/*@DeleteMapping("/{id}")
public ResponseEntity<Void> apagar(@PathVariable Long id) {
    try {
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.noContent().build();
    } catch (ResourceNotFoundException ex) {
        throw ex; // O GlobalExceptionHandler já trata
    }
}
*/