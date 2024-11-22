# Projeto Desafio Academia SAP Commerce

Este repositório registra o projeto desafio da Academia SAP Commerce requisitado pela empresa Accenture.


## Descrição

O projeto tem como objetivo a implementação de uma solução de registros para cursos e alunos dos quais serão utilizados para uma plataforma de cursos online.

### Requisitos Mínimos

- Cadastro de alunos: o Sistema deve permitir que sejam efetivados os cadastros de novos alunos;
- Cadastro de cursos: o Sistema deve permitir que sejam efetivados os cadastros de novos cursos;
- Cadastro de novas inscrições: o Sistema deve permitir que sejam feitas novas inscrições de alunos em cursos;
- Listagem de cursos dos quais um aluno está cadastrado: o Sistema deve permitir que sejam visualizados os cursos dos quais um aluno está cadastrado;
- Listagem de alunos dos quais um curso tem cadastro: o Sistema deve permitir que sejam visualizados os alunos dos quais estão cadastrados em um curso.

# Tecnologias Utilizadas
- Spring Framework
- Java
- MySQL
- Docker


# Como fazer a instalação?
Para instalar o sistema deve-se efetivar os seguintes comandos:

- Clonar repositório (caso não tenha sido clonado ainda): git clone https://github.com/Wesley0010012/DesafioAcademiaSapCommerce
- Entrar no diretório criado (pode variar): cd {SEU_AMBIENTE}/DesafioAcademiaSapCommerce/
- Iniciar contêineres: cd ./development/docker && docker compose up -d --build
- Iniciar utilizando o Maven: mvn spring-boot:run

## Endpoints de Alunos

| Método | Url |  Ação  | Exemplo Corpo | Retorno |
| :-----: | :-- | :---- | :--------          | :------ |
| POST | /aluno/ | Adiciona um novo aluno | `{"nome": "Anatoly Karpov","email": "anatoly@email.com"}` | `{"nome": "Anatoly Karpov","registroAcademico": "c9540bdc-b566-4373-8868-e9d99ad06b2c","email": "anatoly@email.com","dataCadastro": "2024-11-21T23:51:42.060+00:00"}` |

## Endpoints de Cursos

| Método | Url |  Ação  | Exemplo Corpo | Retorno |
| :-----: | :-- | :---- | :--------          | :------ |
| POST | /curso/ | Adiciona um novo curso | `{"nome": "JOGO POSICIONAL","descricao": "Curso de jogo posicional de Xadrez."}` | `{"nome": "JOGO POSICIONAL","registro": "f763498a-687b-4496-838f-6ac451d205ab","descricao": "Curso de jogo posicional de Xadrez.","dataCriacao": "2024-11-21T23:52:15.546+00:00"}` |

## Endpoints de Inscrições

| Método | Url |  Ação  | Exemplo Corpo | Retorno |
| :-----: | :-- | :---- | :--------          | :------ |
| POST | /inscricao/ | Faz uma nova inscrição | `{"registroAluno": "c9540bdc-b566-4373-8868-e9d99ad06b2c","registroCurso": "f763498a-687b-4496-838f-6ac451d205ab"}` | `{"registroAluno": "c9540bdc-b566-4373-8868-e9d99ad06b2c","registroCurso": "f763498a-687b-4496-838f-6ac451d205ab","dataInscricao": "2024-11-22T00:02:09.711+00:00"}` |
| GET | /inscricao/aluno/{REGISTRO_ALUNO} | Faz a busca de cursos do qual um aluno possui registro | `Nenhum` | `[{"curso": "JOGO POSICIONAL","dataInscricao": "2024-11-22T00:02:09.711+00:00"}]` |
| GET | /inscricao/curso/{REGISTRO_CURSO} | Faz a busca de alunos registrados em um curso | `Nenhum` | `[{"nomeAluno": "Henry Townshend","registroAcademico": "2775581d-b868-4280-be65-e76ea1d313d5","dataInscricao": "2024-11-21T23:58:52.904+00:00"},{"nomeAluno": "Anatoly Karpov","registroAcademico": "c9540bdc-b566-4373-8868-e9d99ad06b2c","dataInscricao": "2024-11-22T00:02:09.711+00:00"}]` |

