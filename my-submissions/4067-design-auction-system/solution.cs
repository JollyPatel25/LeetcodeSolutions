public class AuctionSystem {

    private Dictionary<(int userId, int itemId), int> bids;
    private Dictionary<int, SortedSet<(int bid, int user)>> items;

    public AuctionSystem() {
        bids = new Dictionary<(int, int), int>();
        items = new Dictionary<int, SortedSet<(int, int)>>();
    }

    public void AddBid(int userId, int itemId, int bidAmount) {
        if (!items.ContainsKey(itemId))
            items[itemId] = new SortedSet<(int bid, int user)>(
                Comparer<(int bid, int user)>.Create(
                    (a, b) => a.bid != b.bid ? b.bid.CompareTo(a.bid) : b.user.CompareTo(a.user)
                )
            );

        if (bids.ContainsKey((userId, itemId)))
            items[itemId].Remove((bids[(userId, itemId)], userId));

        bids[(userId, itemId)] = bidAmount;
        items[itemId].Add((bidAmount, userId));
    }

    public void UpdateBid(int userId, int itemId, int newAmount) {
        items[itemId].Remove((bids[(userId, itemId)], userId));
        bids[(userId, itemId)] = newAmount;
        items[itemId].Add((newAmount, userId));
    }

    public void RemoveBid(int userId, int itemId) {
        items[itemId].Remove((bids[(userId, itemId)], userId));
        bids.Remove((userId, itemId));
        if (items[itemId].Count == 0)
            items.Remove(itemId);
    }

    public int GetHighestBidder(int itemId) {
        if (!items.ContainsKey(itemId)) return -1;
        return items[itemId].Min.user;
    }
}

