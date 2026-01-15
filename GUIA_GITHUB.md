# Guia para Publicar no GitHub

## Passo 1: Criar Conta no GitHub
1. Acesse: https://github.com
2. Clique em "Sign up"
3. Preencha os dados e crie sua conta

## Passo 2: Criar Repositório Público
1. Após fazer login, clique no botão "+" no canto superior direito
2. Selecione "New repository"
3. Preencha:
   - **Repository name**: `ATM-Sistema` (ou outro nome de sua preferência)
   - **Description**: "Sistema de ATM desenvolvido em Java com arquitetura MVC"
   - **Public**: ✅ Marque como público
   - **NÃO** marque "Initialize this repository with a README"
4. Clique em "Create repository"

## Passo 3: Fazer Commit e Push do Código

### No terminal/CMD, execute os seguintes comandos:

```bash
# 1. Inicializar repositório Git (se ainda não foi feito)
git init

# 2. Adicionar todos os arquivos
git add .

# 3. Fazer o primeiro commit
git commit -m "Sistema ATM completo - Arquitetura MVC com Java, HTML, CSS e JSP"

# 4. Renomear branch para main (se necessário)
git branch -M main

# 5. Adicionar o repositório remoto (SUBSTITUA <seu-usuario> pelo seu usuário do GitHub)
git remote add origin https://github.com/<seu-usuario>/ATM-Sistema.git

# 6. Fazer push do código
git push -u origin main
```

### Exemplo prático:
Se seu usuário do GitHub for `joaosilva`, o comando seria:
```bash
git remote add origin https://github.com/joaosilva/ATM-Sistema.git
```

## Passo 4: Verificar no GitHub
1. Acesse seu repositório no GitHub
2. Verifique se todos os arquivos foram enviados
3. Copie o link do repositório (ex: `https://github.com/seu-usuario/ATM-Sistema`)

## Passo 5: Partilhar o Link
- Envie o link do repositório público para seu professor/avaliador

## Dicas Importantes:
- ✅ Certifique-se de que o repositório está **público**
- ✅ Verifique se o README.md está incluído
- ✅ Todos os arquivos fonte (.java, .jsp, .html, .css) devem estar no repositório
- ✅ O arquivo .gitignore já está configurado para não enviar arquivos compilados
