package com.kloso.gymkanamicuela.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType
import com.kloso.gymkanamicuela.R

class IntroActivity : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setImmersiveMode()
        isWizardMode = true

        addSlide(AppIntroFragment.newInstance(title = "Bienvenida Micuela",
                description = "Bienvenida a la gymkana du roma. En esta aplicación tendrás que ir resolviendo una serie de acertijos para poder descubrir la sorpresa del joves ª",
                imageDrawable = R.drawable.hotel,
                backgroundDrawable = R.drawable.back_slide2,
                titleTypefaceFontRes = R.font.lato,
                descriptionTypefaceFontRes = R.font.lato))

        addSlide(AppIntroFragment.newInstance(title = "Las preguntas",
                description = "Cada pregunta  tiene una única solución correcta, la cual tendrás que introducir. Generalmente, hay dos tipos de preguntas: preguntas que sirven para desbloquear una pista (o algún lugar al que ir who knows) o una pregunta para desbloquear preguntas mas importantes.",
                imageDrawable = R.drawable.acertijo,
                backgroundDrawable = R.drawable.back_slide1,
                titleTypefaceFontRes = R.font.lato,
                descriptionTypefaceFontRes = R.font.lato))

        addSlide(AppIntroFragment.newInstance(title = "Las pistas",
                description = "Cada pregunta tiene una serie de pistas que te ayudarán a resolverlo.",
                imageDrawable = R.drawable.pista,
                backgroundDrawable = R.drawable.back_slide3,
                titleTypefaceFontRes = R.font.lato,
                descriptionTypefaceFontRes = R.font.lato))

        addSlide(AppIntroFragment.newInstance(title = "Finalmente",
                description = "No intentes pedirme ayuda que la vida es dura y el chocolate espeso",
                imageDrawable = R.drawable.harold_manita,
                backgroundDrawable = R.drawable.back_slide5,
                titleTypefaceFontRes = R.font.lato,
                descriptionTypefaceFontRes = R.font.lato))

        setTransformer(AppIntroPageTransformerType.Fade)

    }


    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        finish()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        finish()
    }

}
