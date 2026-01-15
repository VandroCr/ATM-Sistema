# Guia: Como fazer Commit e Push no NetBeans

## 📋 Passo a Passo Completo

### 1️⃣ Abrir o Git no NetBeans

**Opção A - Pelo menu do projeto:**
- Clique com **botão direito** no projeto `ATM-Sistema` (na aba Projects)
- Selecione **Git → Commit...**

**Opção B - Pela aba Team:**
- Vá em **Window → Git** (ou pressione `Ctrl+Shift+G`)
- Isso abre a aba Git na lateral

---

### 2️⃣ Verificar Arquivos Modificados

Na aba **Git** você verá:
- **Modified Files**: Arquivos que foram alterados
- **Untracked Files**: Arquivos novos que ainda não foram adicionados

---

### 3️⃣ Fazer Commit

1. **Selecione os arquivos** que deseja commitar:
   - Marque os arquivos na lista
   - Ou clique em **Select All** para selecionar todos

2. **Digite a mensagem de commit**:
   ```
   Sistema ATM completo - Arquitetura MVC
   ```

3. **Clique em Commit**:
   - Botão **Commit** (canto inferior direito)
   - Ou pressione `Ctrl+K`

---

### 4️⃣ Configurar Repositório Remoto (Primeira vez)

Se ainda não configurou o GitHub:

1. Clique com **botão direito** no projeto → **Git → Remote → Push...**

2. Se aparecer "No remotes configured":
   - Clique em **Manage Remotes...**
   - Clique em **Add**
   - Preencha:
     - **Remote Name**: `origin`
     - **Remote URI**: `https://github.com/VandroCr/ATM-Sistema.git`
   - Clique em **OK**

---

### 5️⃣ Fazer Push para GitHub

1. Clique com **botão direito** no projeto → **Git → Remote → Push...**

2. Na janela que abrir:
   - **Remote Repository**: Selecione `origin`
   - **Branch**: Selecione `main` (ou `master`)
   - Clique em **Next**

3. Na próxima tela:
   - Verifique se está selecionado **Update References**
   - Clique em **Finish**

---

### 6️⃣ Verificar no GitHub

Após o push, acesse:
**https://github.com/VandroCr/ATM-Sistema**

Você deve ver todos os arquivos do projeto lá!

---

## 🔄 Para Futuras Atualizações

Quando fizer mudanças no código:

1. **Commit**: Botão direito no projeto → **Git → Commit...**
   - Selecione arquivos modificados
   - Digite mensagem
   - Clique em **Commit**

2. **Push**: Botão direito no projeto → **Git → Remote → Push...**
   - Selecione `origin` e branch `main`
   - Clique em **Finish**

---

## ⚙️ Configurações Úteis

### Ver histórico de commits:
- Botão direito no projeto → **Git → Show History**

### Ver diferenças:
- Botão direito em um arquivo → **Git → Diff**

### Criar nova branch:
- Botão direito no projeto → **Git → Branch → Create Branch...**

---

## 🆘 Problemas Comuns

### "Authentication failed"
- O NetBeans pode pedir credenciais do GitHub
- Use seu **username** e **Personal Access Token** (não a senha)
- Para criar token: GitHub → Settings → Developer settings → Personal access tokens

### "Branch not found"
- Certifique-se de que a branch está como `main` ou `master`
- Verifique: Botão direito → **Git → Show History**

### "Nothing to commit"
- Todos os arquivos já foram commitados
- Faça uma pequena alteração e tente novamente

---

## 📝 Dica Extra

Você pode usar **atalhos de teclado**:
- `Ctrl+K` - Commit
- `Ctrl+Shift+G` - Abrir aba Git
- `Ctrl+Shift+P` - Push
