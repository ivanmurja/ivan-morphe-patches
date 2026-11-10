package app.ivan.patches.yoosee

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.InstructionLocation.MatchAfterImmediately
import app.morphe.patcher.opcode
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.Opcode

/**
 * LogoActivityVM.parseStartUpIntent(Intent)
 *
 * Trecho decompilado (Yoosee 6.46.1):
 *
 *   if (currentTimeMillis >= 3600000) {
 *       this.mIsLoadAd.postValue(Boolean.TRUE);          // carrega o anuncio de abertura
 *   } else {
 *       l7.b.f(TAG, "crash less than 1 hour goto next page");
 *       this.mSkipIntent.postValue(activeAccountInfo == null ? 1 : 2);  // vai direto pro app
 *   }
 *
 * Em smali:
 *   cmp-long p1, v10, v2
 *   if-gez p1, :cond_14
 *   const-string p1, "crash less than 1 hour goto next page"
 */
object ParseStartUpIntentFingerprint : Fingerprint(
    definingClass = "Lcom/jwkj/vm/LogoActivityVM;",
    returnType = "V",
    parameters = listOf("Landroid/content/Intent;"),
    filters = listOf(
        // Filtro 0: compara o tempo desde o ultimo crash com 1 hora.
        opcode(Opcode.CMP_LONG),
        // Filtro 1: se >= 1 hora, pula pro ramo que mostra o anuncio.
        opcode(Opcode.IF_GEZ, MatchAfterImmediately()),
        // Filtro 2: inicio do ramo que pula o anuncio.
        string("crash less than 1 hour goto next page", location = MatchAfterImmediately()),
    )
)
