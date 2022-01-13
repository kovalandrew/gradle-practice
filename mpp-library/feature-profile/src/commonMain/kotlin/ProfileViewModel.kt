import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class ProfileViewModel(private val eventsDispatcher: EventsDispatcher<Any>): ViewModel() {
    fun onEditProfilePressed() {}
}