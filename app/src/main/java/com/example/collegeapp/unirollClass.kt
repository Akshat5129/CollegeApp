package com.example.collegeapp

class unirollClass {
    companion object {
        var instance = unirollClass()
        public fun getinstance():unirollClass
        {
            return instance
        }
    }
        var univeroll:String?=null

    constructor()
    {

    }

    public fun setItem(university:String)
    {
    this.univeroll=university
    }
    public fun getItem():String?
    {
        return univeroll
    }

}



class AnnouncementCompletion
{
    var completed:Boolean=false

    companion object {
        var instanceannouncement = AnnouncementCompletion()
        public fun getinstance():AnnouncementCompletion
        {
            return instanceannouncement
        }
    }

    constructor()
    {

    }


    public fun setAnnouncement(announce:Boolean)
    {
        this.completed=announce
    }
    public fun getAnnouncement():Boolean
    {
        return completed
    }


}
