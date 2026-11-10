# Ivan Morphe Patches

Patch pessoal para o **Yoosee** (`com.yoosee`): remove o anúncio da tela de abertura.

| Patch | O que faz | Testado em |
|---|---|---|
| Disable splash ad | Pula o anúncio de abertura e vai direto para a lista de câmeras | 6.46.1 |

## Como funciona
Em `LogoActivityVM.parseStartUpIntent`, o app só carrega o anúncio se o último crash foi há mais de 1 hora.
O patch troca o `cmp-long` dessa comparação por uma constante `-1`, então o app sempre usa o próprio
caminho dele que pula o anúncio ("crash less than 1 hour goto next page").

---

# 👋🧩 Morphe Patches template

Template repository for Morphe Patches.

## ❓ About

Patches for apps I like.

<!-- TODO: Update this about section with a brief introduction/summary about this repo and what it offers. -->

### How to use these patches

Click the button below, or manually add this repo url to Morphe Manager: https://github.com/ivanmurja/ivan-morphe-patches

<a href="https://morphe.software/add-source?github=ivanmurja/ivan-morphe-patches">
  <img src=".github/assets/add-to-morphe.svg" alt="Add to Morphe" height="48">
</a>

## 🩹 Patches list

<!-- PATCHES_START EXPANDED -->
> **[v1.0.0-dev.1](https://github.com/ivanmurja/ivan-morphe-patches/releases/tag/v1.0.0-dev.1)**&nbsp;&nbsp;•&nbsp;&nbsp;`dev`&nbsp;&nbsp;•&nbsp;&nbsp;1 patches total
<details open>
<summary>📦 Yoosee&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**Package name:** `com.yoosee`

**🎯 Supported versions:**

| 6.46.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable splash ad](#disable-splash-ad) | Remove o anuncio da tela de abertura e vai direto para a lista de cameras. |  |

</details>

<!-- PATCHES_END -->

### 🛠️ Building locally

- Run `./gradlew buildAndroid`
- The built patches .mpp file is found in `patches/build/libs/patches-*.mpp`
- Patch the mpp file using [Morphe-Desktop](https://github.com/MorpheApp/morphe-desktop)
  like any other patch bundle.

See the [Morphe documentation](https://github.com/MorpheApp/morphe-documentation) for more information.

## 📜 License

UserXYZ Patches are licensed under the [GNU General Public License v3.0](LICENSE)
