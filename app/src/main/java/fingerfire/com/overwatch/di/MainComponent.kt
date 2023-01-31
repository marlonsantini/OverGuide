package fingerfire.com.overwatch.di

import dagger.Subcomponent
import fingerfire.com.overwatch.MainActivity
import fingerfire.com.overwatch.view.ui.allcharacters.HomeFragment

@Subcomponent(modules = [])
interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)

}