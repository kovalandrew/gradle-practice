import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher

fun createAuthViewModel(): AuthViewModel {
    return AuthViewModel(
        eventsDispatcher = EventsDispatcher()
    )
}

fun createProfileViewModel(): ProfileViewModel {
    return ProfileViewModel(
        eventsDispatcher = EventsDispatcher()
    )
}