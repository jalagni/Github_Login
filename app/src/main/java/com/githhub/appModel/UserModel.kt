package com.githhub.appModel

/**
 * Created by mohankumar on 9/8/18.
 */

 data class UserModel (public var login: String = "",
     var id: Int = 0,
     var node_id: String = "",
     var avatar_url: String = "",
     var gravatar_id: String = "",
     var url: String = "",
     var html_url: String = "",
     var followers_url: String = "",
     var following_url: String = "",
     var gists_url: String = "",
     var starred_url: String = "",
     var subscriptions_url: String = "",
     var organizations_url: String = "",
     var repos_url: String = "",
     var events_url: String = "",
     var received_events_url: String = "",
     var type: String = "",
     var site_admin: Boolean = false,
     var public_repos: Int = 0,
     var public_gists: Int = 0,
     var followers: Int = 0,
     var following: Int = 0,
     var created_at: String = "",
     var updated_at: String = "",
     var _gists: Int = 0,
     var total__repos: Int = 0,
     var owned__repos: Int = 0,
     var disk_usage: Int = 0,
     var collaborators: Int = 0,
     var two_factor_authentication: Boolean = false,
     var plan: PlanBean? = null

  
): BaseModel()

data class PlanBean (
    var name: String = "",
    var space: Int = 0,
    var collaborators: Int = 0,
    var private_repos: Int = 0
)
