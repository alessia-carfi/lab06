# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository

```sh
git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
```

2. Ci si assicuri di avere localmente entrambi i branch remoti

```sh
git branch -a
```

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

```sh
git merge remotes/origin/feature
```

4. Si noti che viene generato un **merge conflict**!

```sh
git status
```

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

```sh
micro HelloWord.java
javac HelloWord.java
java HelloWord
git add .
git commit -m "conflict resolved"
```

6. Si crei un nuovo repository nel proprio github personale

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

```sh
git remote set-url origin https://github.com/alessia-carfi/OOP-git-merge-conflict-test.git
```

8. Si faccia push del branch `master` sul proprio repository

```sh
git push
```

9. Si setti il branch remoto `master` del nuovo repository come _upstream_ per il proprio branch `master` locale
