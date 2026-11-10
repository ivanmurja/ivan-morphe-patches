package app.ivan.patches.yoosee

import app.ivan.patches.shared.Constants.COMPATIBILITY_YOOSEE
import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.iface.instruction.ThreeRegisterInstruction

@Suppress("unused")
val disableSplashAdPatch = bytecodePatch(
    name = "Disable splash ad",
    description = "Remove o anuncio da tela de abertura e vai direto para a lista de cameras.",
    default = true
) {
    compatibleWith(COMPATIBILITY_YOOSEE)

    execute {
        ParseStartUpIntentFingerprint.let {
            // Troca "cmp-long vX, ..." por "const/16 vX, -0x1".
            // Assim o "if-gez" seguinte nunca pula, e o app segue pelo proprio
            // caminho dele que nao carrega anuncio (o mesmo usado apos um crash).
            val cmpMatch = it.instructionMatches[0]
            val register = cmpMatch.getInstruction<ThreeRegisterInstruction>().registerA

            it.method.replaceInstruction(cmpMatch.index, "const/16 v$register, -0x1")
        }
    }
}
