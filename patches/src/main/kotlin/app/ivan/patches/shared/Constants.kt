package app.ivan.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    val COMPATIBILITY_YOOSEE = Compatibility(
        name = "Yoosee",
        packageName = "com.yoosee",
        // No APKPure/APKMirror o Yoosee vem como pacote dividido (XAPK).
        apkFileType = ApkFileType.XAPK,
        appIconColor = 0x1E88E5,
        targets = listOf(
            // Versao usada para desenvolver e testar o patch.
            AppTarget(version = "6.46.1"),
            // Versoes futuras: deve funcionar enquanto o trecho nao mudar.
            AppTarget(version = null, isExperimental = true),
        )
    )
}
