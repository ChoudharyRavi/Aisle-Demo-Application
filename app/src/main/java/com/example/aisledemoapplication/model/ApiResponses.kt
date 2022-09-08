package com.example.aisledemoapplication.model

import com.google.gson.annotations.SerializedName

data class NotesApiResponse(

	@field:SerializedName("invites")
	val invites: Invites,

	@field:SerializedName("likes")
	val likes: Likes
)

data class MotherTongue(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class PreferencesItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("preference_question")
	val preferenceQuestion: PreferenceQuestion,

	@field:SerializedName("answer_id")
	val answerId: Int,

	@field:SerializedName("value")
	val value: Int,

	@field:SerializedName("answer")
	val answer: String,

	@field:SerializedName("second_choice")
	val secondChoice: String,

	@field:SerializedName("first_choice")
	val firstChoice: String
)

data class ExperienceV1(

	@field:SerializedName("name_alias")
	val nameAlias: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class Invites(

	@field:SerializedName("pending_invitations_count")
	val pendingInvitationsCount: Int,

	@field:SerializedName("profiles")
	val profiles: List<ProfilesItem>,

	@field:SerializedName("totalPages")
	val totalPages: Int
)

data class HighestQualificationV1(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("preference_only")
	val preferenceOnly: Boolean
)

data class ProfilesItem(

	@field:SerializedName("preferences")
	val preferences: List<PreferencesItem>,

	@field:SerializedName("lng")
	val lng: Double,

	@field:SerializedName("last_seen")
	val lastSeen: Any,

	@field:SerializedName("work")
	val work: Work,

	@field:SerializedName("last_seen_window")
	val lastSeenWindow: String,

	@field:SerializedName("has_active_subscription")
	val hasActiveSubscription: Boolean,

	@field:SerializedName("user_interests")
	val userInterests: List<Any>,

	@field:SerializedName("verification_status")
	val verificationStatus: String,

	@field:SerializedName("photos")
	val photos: List<PhotosItem>,

	@field:SerializedName("show_concierge_badge")
	val showConciergeBadge: Boolean,

	@field:SerializedName("approved_time")
	val approvedTime: Double,

	@field:SerializedName("general_information")
	val generalInformation: GeneralInformation,

	@field:SerializedName("profile_data_list")
	val profileDataList: List<ProfileDataListItem>,

	@field:SerializedName("instagram_images")
	val instagramImages: Any,

	@field:SerializedName("disapproved_time")
	val disapprovedTime: Double,

	@field:SerializedName("online_code")
	val onlineCode: Int,

	@field:SerializedName("is_facebook_data_fetched")
	val isFacebookDataFetched: Boolean,

	@field:SerializedName("icebreakers")
	val icebreakers: Any,

	@field:SerializedName("meetup")
	val meetup: Any,

	@field:SerializedName("lat")
	val lat: Double,

	@field:SerializedName("story")
	val story: Any,

	@field:SerializedName("avatar")
	val avatar: String,

	@field:SerializedName("first_name")
	val firstName: String
)

data class Work(

	@field:SerializedName("experience_v1")
	val experienceV1: ExperienceV1,

	@field:SerializedName("industry_v1")
	val industryV1: IndustryV1,

	@field:SerializedName("highest_qualification_v1")
	val highestQualificationV1: HighestQualificationV1,

	@field:SerializedName("monthly_income_v1")
	val monthlyIncomeV1: Any,

	@field:SerializedName("field_of_study_v1")
	val fieldOfStudyV1: FieldOfStudyV1
)

data class IndustryV1(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("preference_only")
	val preferenceOnly: Boolean
)

data class SmokingV1(

	@field:SerializedName("name_alias")
	val nameAlias: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class ProfileDataListItem(

	@field:SerializedName("preferences")
	val preferences: List<PreferencesItem>,

	@field:SerializedName("question")
	val question: String,

	@field:SerializedName("invitation_type")
	val invitationType: String
)

data class Likes(

	@field:SerializedName("likes_received_count")
	val likesReceivedCount: Int,

	@field:SerializedName("profiles")
	val profiles: List<ProfilesItem>,

	@field:SerializedName("can_see_profile")
	val canSeeProfile: Boolean
)

data class PhotosItem(

	@field:SerializedName("photo_id")
	val photoId: Int,

	@field:SerializedName("photo")
	val photo: String,

	@field:SerializedName("selected")
	val selected: Boolean,

	@field:SerializedName("status")
	val status: String
)

data class GeneralInformation(

	@field:SerializedName("ref_id")
	val refId: String,

	@field:SerializedName("politics")
	val politics: Any,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("date_of_birth")
	val dateOfBirth: String,

	@field:SerializedName("smoking_v1")
	val smokingV1: SmokingV1,

	@field:SerializedName("kid")
	val kid: Any,

	@field:SerializedName("settle")
	val settle: Any,

	@field:SerializedName("faith")
	val faith: Faith,

	@field:SerializedName("cast")
	val cast: Any,

	@field:SerializedName("drinking_v1")
	val drinkingV1: DrinkingV1,

	@field:SerializedName("marital_status_v1")
	val maritalStatusV1: MaritalStatusV1,

	@field:SerializedName("sun_sign_v1")
	val sunSignV1: SunSignV1,

	@field:SerializedName("date_of_birth_v1")
	val dateOfBirthV1: String,

	@field:SerializedName("mbti")
	val mbti: Any,

	@field:SerializedName("location")
	val location: Location,

	@field:SerializedName("diet")
	val diet: Any,

	@field:SerializedName("first_name")
	val firstName: String,

	@field:SerializedName("pet")
	val pet: Any,

	@field:SerializedName("age")
	val age: Int,

	@field:SerializedName("mother_tongue")
	val motherTongue: MotherTongue,

	@field:SerializedName("height")
	val height: Int
)

data class Faith(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class FieldOfStudyV1(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class MaritalStatusV1(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("preference_only")
	val preferenceOnly: Boolean
)

data class PreferenceQuestion(

	@field:SerializedName("second_choice")
	val secondChoice: String,

	@field:SerializedName("first_choice")
	val firstChoice: String
)

data class DrinkingV1(

	@field:SerializedName("name_alias")
	val nameAlias: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class Location(

	@field:SerializedName("summary")
	val summary: String,

	@field:SerializedName("full")
	val full: String
)

data class SunSignV1(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
)

data class PhoneNumberResponse(

	@field:SerializedName("status")
	val status: Boolean
)

data class TokenResponse(

	@field:SerializedName("token")
	val token: String
)
