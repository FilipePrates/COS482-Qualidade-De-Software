# COS482-Qualidade-De-Software

Enunciado do Trabalho em Grupo
Objetivo: Implementação de um processo de negócio usando o SCRUB4PA como guia.
Por implementação, ou automação de um processo, entende-se a construção de um sistema de software (Process Aware Information System) que apoia e controla a execução das tarefas associadas a um modelo de processo. Pretende-se neste passo utilizar a plataforma AgileKip que permite gerar uma implementação executável de um subprocesso BPMN modelado. 

Dado que este passo do trabalho se destina a perceber e obter experiência “hands-on” no uso de um Processo de Software (SCRUb4PA)  e não a implementar um sistema real e completo, apenas iremos considerar o seguinte subconjunto das abstrações de modelação disponíveis em BPMN: Start Event, End Event, Timer Event, User Event,  User Task, Service Task, Message Task, Subprocess e Gateways. O processo escolhido deve ter pelo menos 4 (quatro) elementos de modelagem por membro do grupo. Por elementos de modelação entendem-se Eventos, Tarefas e Gateways (os fluxos não contam). 

Uma vez que a plataforma AgileKip é baseada no Camunda Workflow Engine (Community Edition), cuja cobertura do metamodelo da linguagem BPMN é a aqui indicada (símbolos na cor laranja) (https://docs.camunda.org/manual/7.16/reference/bpmn20/), o processo BPMN escolhido, deve ser modelado na ferramenta Camunda Modeler, para confirmação da compatibilidade. 

Para a geração do código será necessário produzir um conjunto de especificações em formato JSON descrevendo entidades auxiliares como telas  e entidades de domínio, tal como descrito na documentação encontrada em AgileKip. Será ainda necessário produzir alguns trechos de código em Java e JavaScript, para os quais são disponibilizados exemplos ilustrativos.

Processo de Software 

SCRU4PA => https://rmpillat.github.io/

Roadmap das Entregas (tentativa)

O trabalho será dividido em 3 iterações que deverão estar inseridas e controladas no GitHub Projects

Iteração 1 - Entrega dia 18/10/2022

Apresentação com entrega dos artefatos descritos nas fases do SCRUB4PA (Ex: Doc. Visão, BPMN, etc.)

Iteração 2 - Entrega dia 17/11/2022

Apresentação com entrega  dos artefatos descritos nas fases do SCRUB4PA (Ex: Json das Entidades, Json dos Forms, PAIS executando minimamente, etc.)

Iteração 3 - Entrega dia 13/12/2022

Apresentação com entrega  dos artefatos descritos nas fases do SCRUB4PA (Ex:  PAIS Completo, Checklist BPMN, etc.)



Para demonstrar a implementação do sistema, devem ser disponibilizados artefatos no GitHub, Github Project e GitHub Wiki (ou diretório de documentação com texto em markdown):

