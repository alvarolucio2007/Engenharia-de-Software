from supabase import create_client

url = "SUPABASE_URL"
key = "SUPABASE_KEY"

try:
    supabase = create_client(url, key)
except Exception:
    print("Did not connect")

query = "select * from aluno"
result = supabase.table("aluno").select("name,course").execute()
print(50 * "-" + "normal" + 50 * "-")
for data in result.data:
    print(data)
all_eng_soft = (
    supabase.table("aluno").select("*").eq("course", "Engenharia de Software").execute()
)
print(50 * "-" + "only eng soft" + 50 * "-")
for data in all_eng_soft.data:
    print(data)
not_admin = supabase.table("aluno").select("*").neq("course", "Administração").execute()
print(50 * "-" + "not administração" + 50 * "-")
for data in not_admin.data:
    print(data)
period_gt_4 = supabase.table("aluno").select("*").gt("period", 4).execute()
print(50 * "-" + "greater than 4" + 50 * "-")
for data in period_gt_4.data:
    print(data)
period_gte_4 = supabase.table("aluno").select("*").gte("period", 4).execute()
print(50 * "-" + "greater than equal 4" + 50 * "-")
for data in period_gte_4.data:
    print(data)
period_lt_5 = supabase.table("aluno").select("*").lt("period", 5).execute()
print(50 * "-" + "less than 5" + 50 * "-")
for data in period_lt_5.data:
    print(data)
period_lte_4 = supabase.table("aluno").select("*").lte("period", 4).execute()
print(50 * "-" + "less than equal 4" + 50 * "-")
for data in period_lte_4.data:
    print(data)
double_filter = (
    supabase.table("aluno")
    .select("*")
    .gt("period", 3)
    .eq("course", "Engenharia de Software")
    .execute()
)
print(50 * "-" + "double filter" + 50 * "-")
for data in double_filter.data:
    print(data)

challenge = (
    supabase.table("aluno")
    .select("*")
    .gte("period", 4)
    .neq("course", "Administração")
    .execute()
)
print(50 * "-" + "challenge" + 50 * "-")
for data in double_filter.data:
    print(data)
