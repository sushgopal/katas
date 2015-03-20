class TennisMatch
	def initialize(left_player, right_player)
		@scores = { left_player => 0, right_player => 0 }
	end

	def point_to(scorer)
		@scores[scorer] += 15
	end

	def score(player)
		@scores[player]
	end
end
