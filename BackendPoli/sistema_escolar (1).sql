-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Jun-2025 às 17:17
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistema_escolar`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  `nome_completo` varchar(255) NOT NULL,
  `numero_processo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `classes`
--

CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

CREATE TABLE `disciplinas` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `codigo_disciplina` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `faltas`
--

CREATE TABLE `faltas` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  `data_falta` date NOT NULL,
  `justificada` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `materiais_didaticos`
--

CREATE TABLE `materiais_didaticos` (
  `id` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descricao` text DEFAULT NULL,
  `caminho_arquivo` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medias_finais`
--

CREATE TABLE `medias_finais` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  `media_trimestre1` decimal(5,2) DEFAULT NULL,
  `media_trimestre2` decimal(5,2) DEFAULT NULL,
  `media_trimestre3` decimal(5,2) DEFAULT NULL,
  `media_final` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `notas_trimestre1`
--

CREATE TABLE `notas_trimestre1` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  `avaliacao1` decimal(5,2) DEFAULT NULL,
  `avaliacao2` decimal(5,2) DEFAULT NULL,
  `avaliacao3` decimal(5,2) DEFAULT NULL,
  `avaliacao4` decimal(5,2) DEFAULT NULL,
  `avaliacao5` decimal(5,2) DEFAULT NULL,
  `mac` decimal(5,2) DEFAULT NULL,
  `nota_prova_professor` decimal(5,2) DEFAULT NULL,
  `nota_prova_trimestral` decimal(5,2) DEFAULT NULL,
  `media_trimestral` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `notas_trimestre2`
--

CREATE TABLE `notas_trimestre2` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  `avaliacao1` decimal(5,2) DEFAULT NULL,
  `avaliacao2` decimal(5,2) DEFAULT NULL,
  `avaliacao3` decimal(5,2) DEFAULT NULL,
  `avaliacao4` decimal(5,2) DEFAULT NULL,
  `avaliacao5` decimal(5,2) DEFAULT NULL,
  `mac` decimal(5,2) DEFAULT NULL,
  `nota_prova_professor` decimal(5,2) DEFAULT NULL,
  `nota_prova_trimestral` decimal(5,2) DEFAULT NULL,
  `media_trimestral` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `notas_trimestre3`
--

CREATE TABLE `notas_trimestre3` (
  `id` int(11) NOT NULL,
  `id_aluno` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  `avaliacao1` decimal(5,2) DEFAULT NULL,
  `avaliacao2` decimal(5,2) DEFAULT NULL,
  `avaliacao3` decimal(5,2) DEFAULT NULL,
  `avaliacao4` decimal(5,2) DEFAULT NULL,
  `avaliacao5` decimal(5,2) DEFAULT NULL,
  `mac` decimal(5,2) DEFAULT NULL,
  `nota_prova_professor` decimal(5,2) DEFAULT NULL,
  `nota_prova_trimestral` decimal(5,2) DEFAULT NULL,
  `media_trimestral` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE `professores` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `nome_completo` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor_disciplina_turma`
--

CREATE TABLE `professor_disciplina_turma` (
  `id_professor` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL,
  `id_turma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `registros_atividade`
--

CREATE TABLE `registros_atividade` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `acao` varchar(255) NOT NULL,
  `tabela_afetada` varchar(100) DEFAULT NULL,
  `id_registro` int(11) DEFAULT NULL,
  `data_hora` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `turmas`
--

CREATE TABLE `turmas` (
  `id` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `ano_letivo` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome_usuario` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `numero_do_passe` int(255) NOT NULL,
  `tipo_usuario` enum('admin','professor','aluno') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numero_processo` (`numero_processo`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_turma` (`id_turma`);

--
-- Índices para tabela `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_disciplina` (`codigo_disciplina`);

--
-- Índices para tabela `faltas`
--
ALTER TABLE `faltas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_disciplina` (`id_disciplina`);

--
-- Índices para tabela `materiais_didaticos`
--
ALTER TABLE `materiais_didaticos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_professor` (`id_professor`,`id_disciplina`,`id_turma`);

--
-- Índices para tabela `medias_finais`
--
ALTER TABLE `medias_finais`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_disciplina` (`id_disciplina`);

--
-- Índices para tabela `notas_trimestre1`
--
ALTER TABLE `notas_trimestre1`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_disciplina` (`id_disciplina`);

--
-- Índices para tabela `notas_trimestre2`
--
ALTER TABLE `notas_trimestre2`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_disciplina` (`id_disciplina`);

--
-- Índices para tabela `notas_trimestre3`
--
ALTER TABLE `notas_trimestre3`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_aluno` (`id_aluno`),
  ADD KEY `id_disciplina` (`id_disciplina`);

--
-- Índices para tabela `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices para tabela `professor_disciplina_turma`
--
ALTER TABLE `professor_disciplina_turma`
  ADD PRIMARY KEY (`id_professor`,`id_disciplina`,`id_turma`),
  ADD KEY `id_disciplina` (`id_disciplina`),
  ADD KEY `id_turma` (`id_turma`);

--
-- Índices para tabela `registros_atividade`
--
ALTER TABLE `registros_atividade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices para tabela `turmas`
--
ALTER TABLE `turmas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_classe` (`id_classe`);

--
-- Índices para tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nome_usuario` (`nome_usuario`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `numero_do_passe` (`numero_do_passe`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `alunos`
--
ALTER TABLE `alunos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `classes`
--
ALTER TABLE `classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `faltas`
--
ALTER TABLE `faltas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `materiais_didaticos`
--
ALTER TABLE `materiais_didaticos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `medias_finais`
--
ALTER TABLE `medias_finais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `notas_trimestre1`
--
ALTER TABLE `notas_trimestre1`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `notas_trimestre2`
--
ALTER TABLE `notas_trimestre2`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `notas_trimestre3`
--
ALTER TABLE `notas_trimestre3`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `professores`
--
ALTER TABLE `professores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `registros_atividade`
--
ALTER TABLE `registros_atividade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `turmas`
--
ALTER TABLE `turmas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `alunos`
--
ALTER TABLE `alunos`
  ADD CONSTRAINT `alunos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `alunos_ibfk_2` FOREIGN KEY (`id_turma`) REFERENCES `turmas` (`id`);

--
-- Limitadores para a tabela `faltas`
--
ALTER TABLE `faltas`
  ADD CONSTRAINT `faltas_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`),
  ADD CONSTRAINT `faltas_ibfk_2` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`);

--
-- Limitadores para a tabela `materiais_didaticos`
--
ALTER TABLE `materiais_didaticos`
  ADD CONSTRAINT `materiais_didaticos_ibfk_1` FOREIGN KEY (`id_professor`,`id_disciplina`,`id_turma`) REFERENCES `professor_disciplina_turma` (`id_professor`, `id_disciplina`, `id_turma`);

--
-- Limitadores para a tabela `medias_finais`
--
ALTER TABLE `medias_finais`
  ADD CONSTRAINT `medias_finais_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`),
  ADD CONSTRAINT `medias_finais_ibfk_2` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`);

--
-- Limitadores para a tabela `notas_trimestre1`
--
ALTER TABLE `notas_trimestre1`
  ADD CONSTRAINT `notas_trimestre1_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`),
  ADD CONSTRAINT `notas_trimestre1_ibfk_2` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`);

--
-- Limitadores para a tabela `notas_trimestre2`
--
ALTER TABLE `notas_trimestre2`
  ADD CONSTRAINT `notas_trimestre2_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`),
  ADD CONSTRAINT `notas_trimestre2_ibfk_2` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`);

--
-- Limitadores para a tabela `notas_trimestre3`
--
ALTER TABLE `notas_trimestre3`
  ADD CONSTRAINT `notas_trimestre3_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `alunos` (`id`),
  ADD CONSTRAINT `notas_trimestre3_ibfk_2` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`);

--
-- Limitadores para a tabela `professores`
--
ALTER TABLE `professores`
  ADD CONSTRAINT `professores_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Limitadores para a tabela `professor_disciplina_turma`
--
ALTER TABLE `professor_disciplina_turma`
  ADD CONSTRAINT `professor_disciplina_turma_ibfk_1` FOREIGN KEY (`id_professor`) REFERENCES `professores` (`id`),
  ADD CONSTRAINT `professor_disciplina_turma_ibfk_2` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplinas` (`id`),
  ADD CONSTRAINT `professor_disciplina_turma_ibfk_3` FOREIGN KEY (`id_turma`) REFERENCES `turmas` (`id`);

--
-- Limitadores para a tabela `registros_atividade`
--
ALTER TABLE `registros_atividade`
  ADD CONSTRAINT `registros_atividade_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Limitadores para a tabela `turmas`
--
ALTER TABLE `turmas`
  ADD CONSTRAINT `turmas_ibfk_1` FOREIGN KEY (`id_classe`) REFERENCES `classes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
