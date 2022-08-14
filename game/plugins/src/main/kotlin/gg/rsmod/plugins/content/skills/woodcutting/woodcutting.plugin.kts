package gg.rsmod.plugins.content.skills.woodcutting

import gg.rsmod.plugins.content.skills.woodcutting.Woodcutting.Tree

/**TODO:
 * check trunk correct ids and tree ids
 */

private val TREES = setOf(
    Tree(TreeType.TREE, obj = 1276, trunk = 1342),
    Tree(TreeType.TREE, obj = 1278, trunk = 1342),
    Tree(TreeType.TREE, obj = 1279, trunk = 1345), // Dark tree
    Tree(TreeType.TREE, obj = 1282, trunk = 1347), // Dead tree
    Tree(TreeType.TREE, obj = 1283, trunk = 1347), // Dead tree
    Tree(TreeType.TREE, obj = 1284, trunk = 6212), // Dead tree
    Tree(TreeType.TREE, obj = 1285, trunk = 1349), // Orange dead tree
    Tree(TreeType.TREE, obj = 1286, trunk = 1351), // Dead tree
    Tree(TreeType.TREE, obj = 1289, trunk = 1353), // Dead tree
    Tree(TreeType.TREE, obj = 1365, trunk = 1352), // Green dead tree
    Tree(TreeType.TREE, obj = 1383, trunk = 1358), // Dead tree
    Tree(TreeType.TREE, obj = 1384, trunk = 1359),
    Tree(TreeType.TREE, obj = 2091, trunk = 1342), // Evergreen
    Tree(TreeType.TREE, obj = 2092, trunk = 1355), // Evergreen
    Tree(TreeType.TREE, obj = 3648, trunk = 3649), // Dying tree
    Tree(TreeType.TREE, obj = 3879, trunk = 3880), // Tree pine
    Tree(TreeType.TREE, obj = 3881, trunk = 3880), // Tree pine
    Tree(TreeType.TREE, obj = 3882, trunk = 3880), // Tree pine
    Tree(TreeType.TREE, obj = 5903, trunk = 1351), // Dead tree
    Tree(TreeType.TREE, obj = 5904, trunk = 1351), // Dead tree
    Tree(TreeType.TREE, obj = 30852, trunk = 30855), // Burnt tree
    Tree(TreeType.TREE, obj = 30854, trunk = 30856), // Burnt tree

    Tree(TreeType.ACHEY, obj = 2023, trunk = 3371),

    Tree(TreeType.OAK, obj = 1751, trunk = 1356),
    Tree(TreeType.OAK, obj = 10820, trunk = 1356),

    Tree(TreeType.WILLOW, obj = 1750, trunk = 9711),
    Tree(TreeType.WILLOW, obj = 1756, trunk = 9471),
    Tree(TreeType.WILLOW, obj = 1758, trunk = 9471),
    Tree(TreeType.WILLOW, obj = 1760, trunk = 9471),
    Tree(TreeType.WILLOW, obj = 10819, trunk = 9711),
    Tree(TreeType.WILLOW, obj = 10829, trunk = 9471),
    Tree(TreeType.WILLOW, obj = 10831, trunk = 9471),
    Tree(TreeType.WILLOW, obj = 10833, trunk = 9471),

    Tree(TreeType.TEAK, obj = 9036, trunk = 9037),
    Tree(TreeType.TEAK, obj = 15062, trunk = 9037),

    Tree(TreeType.JUNIPER, obj = 27499, trunk = 27500),

    Tree(TreeType.MAPLE, obj = 1759, trunk = 9712),
    Tree(TreeType.MAPLE, obj = 4674, trunk = 9712),
    Tree(TreeType.MAPLE, obj = 10832, trunk = 9712),

    Tree(TreeType.HOLLOW, obj = 1752, trunk = 2310),
    Tree(TreeType.HOLLOW, obj = 1757, trunk = 4061),
    Tree(TreeType.HOLLOW, obj = 10821, trunk = 2310),
    Tree(TreeType.HOLLOW, obj = 10830, trunk = 4061),

    Tree(TreeType.MAHOGANY, obj = 9034, trunk = 9035),

    Tree(TreeType.ARCTIC_PINE, obj = 3037, trunk = 21274),

    Tree(TreeType.YEW, obj = 1753, trunk = 9714),
    Tree(TreeType.YEW, obj = 1754, trunk = 9714),
    Tree(TreeType.YEW, obj = 10822, trunk = 9714),
    Tree(TreeType.YEW, obj = 10823, trunk = 9714),
    Tree(TreeType.YEW, obj = 10828, trunk = 9714),

    Tree(TreeType.MAGIC, obj = 1761, trunk = 9713),
    Tree(TreeType.MAGIC, obj = 10834, trunk = 9713),
    Tree(TreeType.MAGIC, obj = 10835, trunk = 9713),

    Tree(TreeType.REDWOOD, obj = 29668, trunk = 29669),
    Tree(TreeType.REDWOOD, obj = 29670, trunk = 29671)
)

TREES.forEach { tree ->
    on_obj_option(obj = tree.obj, option = 1) {
        val obj = player.getInteractingGameObj()
        player.queue {
            Woodcutting.chopDownTree(this, obj, tree.type, tree.trunk)
        }
    }
}