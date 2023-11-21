package com.example.littlelemon

interface Destinations {
    val route: String
}
object HomeDestinations : Destinations{
    override val route = "Home"
}
object ProfileDestinations : Destinations{
    override val route = "Profile"
}
object OnboardDestination : Destinations {
    override val route = "Onboarding"
}