// Atualizar BuscarPorId
@Override
public TurmaResponse BuscarPorId(Long id) {
    Turma turma = turmaRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Turma", id));
    return mapToResponse(turma);
}

// Corrigir o mapToResponse (estava invertido)
@Override
public TurmaResponse mapToResponse(Turma turma) {
    TurmaResponse response = new TurmaResponse();
    response.setId(turma.getId());
    response.setNome(turma.getNome());
    response.setAnoLetivo(turma.getAnoLetivo());
    response.setClasse(turma.getClasse());
    response.setCurso(turma.getCurso());
    response.setPeriodo(turma.getPeriodo());
    response.setNivelEnsino(turma.getNivelEnsino());
    return response;
}
