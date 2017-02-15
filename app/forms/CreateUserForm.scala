package forms

/**
  * Form containing data to create a user.
  *
  * @param name username
  */

case class CreateUserForm(name: String, password: String, mentor: Boolean)
