require_relative 'tennis'

RSpec.describe TennisMatch, "#score" do
	before(:each) do
		@match = TennisMatch.new(:player_one, :player_two)
	end
	it "player one has no score" do
		expect(@match.score(:player_one)).to eq(0)
	end
	it "player two has no score" do
		expect(@match.score(:player_two)).to eq(0)
	end
	it "player one scores first point" do
		playerOneScores()
		expect(@match.score(:player_one)).to eq(15)
	end
	it "both players score" do
		playerOneScores()
		playerTwoScores()
		expect(@match.score(:player_one)).to eq(15)
		expect(@match.score(:player_two)).to eq(15)
	end
	it "player one scores twice" do
		playerOneScores(2)
		expect(@match.score(:player_one)).to eq(30)
	end

	def playerOneScores(times = 1)
		playerScores(:player_one, times)
	end
	def playerTwoScores(times = 1)
		playerScores(:player_two, times)
	end

	def playerScores(player, times)
		times.times do
			@match.point_to(player)
		end
	end
end