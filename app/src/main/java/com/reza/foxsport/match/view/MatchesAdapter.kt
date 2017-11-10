package com.reza.foxsport.match.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.reza.foxsport.R
import com.reza.foxsport.Utils.API
import com.reza.foxsport.match.model.Match
import kotlinx.android.synthetic.main.match_details.view.*
import kotlinx.android.synthetic.main.match_item.view.*



/**
 * Created by reza on 5/11/17.
 */
class MatchesAdapter(callback: Callback) : RecyclerView.Adapter<MatchesAdapter.ItemMatchViewHolder>() {

    private var mcallback: Callback? = null
    private var matches: MutableList<Match>? = null
    private var context: Context? = null

    init {
        mcallback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemMatchViewHolder {
        context = parent?.context
        val layoutInflater = LayoutInflater.from(parent?.context)
        return ItemMatchViewHolder(layoutInflater.inflate(R.layout.match_item, parent, false))
    }
    override fun onBindViewHolder(holder: ItemMatchViewHolder?, position: Int) {
        val match = matches?.get(position)
        holder?.matchStatType?.text = matches?.get(position)?.getStatType()

        val playerAPicURL = API.PLAYER_PIC_URL.value.replace("@playerId",
                matches?.get(position)?.getTeamA()?.getTopPlayers()?.get(position)?.getId().toString())

        Glide.with(context).load(playerAPicURL)
                .placeholder(R.drawable.headshot_blank_large)
                .error(R.drawable.headshot_blank_large)
                .into(holder?.matchPalyerAImage)

        holder?.matchPalyerAShortName?.text = matches?.get(position)?.getTeamA()?.getTopPlayers()?.get(position)?.getShortName()
        holder?.matchPalyerAJumperNumber?.text = matches?.get(position)?.getTeamA()?.getTopPlayers()?.get(position)?.getJumperNumber().toString()
        holder?.matchPalyerAPosition?.text = matches?.get(position)?.getTeamA()?.getTopPlayers()?.get(position)?.getPosition()



        val playerBPicURL = API.PLAYER_PIC_URL.value.replace("@playerId",
                matches?.get(position)?.getTeamB()?.getTopPlayers()?.get(position)?.getId().toString())

        Glide.with(context).load(playerBPicURL)
                .placeholder(R.drawable.headshot_blank_large)
                .error(R.drawable.headshot_blank_large)
                .into(holder?.matchPalyerBImage)

        holder?.matchPalyerBShortName?.text = matches?.get(position)?.getTeamB()?.getTopPlayers()?.get(position)?.getShortName()
        holder?.matchPalyerBJumperNumber?.text = matches?.get(position)?.getTeamB()?.getTopPlayers()?.get(position)?.getJumperNumber().toString()
        holder?.matchPalyerBPosition?.text = matches?.get(position)?.getTeamB()?.getTopPlayers()?.get(position)?.getPosition()

        holder?.itemView?.setOnClickListener({ view ->
            if (match != null) {
                mcallback?.onMatchClicked(match)
            }
        })
    }

    override fun getItemCount(): Int {
        if(matches != null) {
            return matches?.size!!
        } else
            return 1
    }

    fun updateMatches(matches: MutableList<Match>?) {
        this.matches = matches
    }

    interface Callback {
        fun onMatchClicked(match: Match)
    }

    class ItemMatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var matchStatType = view.tv_statType

        var matchPalyerAImage = view.iv_palyerA
        var matchPalyerAShortName = view.tv_palyerAShortName
        var matchPalyerAJumperNumber = view.tv_palyerAJumperNumber
        var matchPalyerAPosition = view.tv_palyerAPosition

        var matchPalyerBImage = view.iv_palyerB
        var matchPalyerBShortName = view.tv_palyerBShortName
        var matchPalyerBJumperNumber = view.tv_palyerBJumperNumber
        var matchPalyerBPosition = view.tv_palyerBPosition
    }

}
